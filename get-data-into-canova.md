---
layout: default
title: "Getting Data Into Canova"
description: ""
---


## Raw Text as Input

* Input Format: TextInputFormat
    * org.canova.cli.formats.input.TextInputFormat
* Record Schema coming out of input format: { csvLineString, dirLabelString } 
    * label of record is second string in Collection<Writable>

### Explanation of Input Formats and Record Readers based on FileRecordReader

* TextInputFormat's record reader is based on the FileRecordReader
    * A record reader understands how to read a single record out of a file or directory as a unique record to process
* Any input format (and record reader combination) that uses the FileRecordReader parent class (Image, Text, most) will automatically generate a label for the record
* The system will look at the subdirectories in the input directory listed and then for every record in that subdirectory will attach a "label" to it as the string name of the subdirectory (in some cases a unique ID)

### Setting up Data For Canova's TextInputFormat

* In the case of the text vectorization pipeline in Canova, we see that every line a document is considered a unique record
* We want to prepare our data so that each line represents a unique vector we want to see in our output
* Each subdirectory we put these files containing records in represents a label in our dataset
* Example: Spam and Ham would have two directories under the main input directory (./input/spam and ./input/ham) and that's how we get labels into Canova
    * these labels will show up in the vectorized output as integers

Example Directory Structure

    ../input/spam
    ../input/ham

With 1 or many files inside each directory representing records of the class labeled by the subdirectory name. The names are not as important given eventually the labels become integers in the vectorized output.

Example of vectorized output:

    cat /tmp/canova/text/svm_light_unit_test_0_output.txt 
    0.0 1:0.1436278074979782 2:0.1436278074979782 3:0.210410937666893
    0.0 1:0.1436278074979782 2:0.1436278074979782 4:0.210410937666893
    0.0 5:0.22764469683170319 6:0.210410937666893 7:0.210410937666893 8:0.210410937666893 9:0.210410937666893 10:0.210410937666893
    1.0 11:0.210410937666893 12:0.210410937666893 13:0.210410937666893 14:0.210410937666893 15:0.210410937666893


### Text Example Configuration File

    canova.input.header.skip=false
    canova.input.statistics.debug.print=false
    canova.input.data.type=text
    canova.input.format=org.canova.cli.formats.input.TextInputFormat
    canova.input.directory=src/test/resources/text/data/unit_test_0/
    canova.output.directory=/tmp/canova/text/svm_light_unit_test_0_output.txt
    canova.output.format=org.canova.api.formats.output.impl.SVMLightOutputFormat

### What Happens When I Dont Have a Label (New Data)

* For Text, Image, and Custom
    * Just put them in a subdirectory with some default name
    * The system will either use this and index to 0 or use some default name
    * Either way, each record will have a dummy label that we'll ignore when we classify them later on with our model
* For CSV Data
    * [ TODO: double check this, make sure the CSV pipeline doesn't just flip out ]


## CSV Records as Input

Many databases export data as CSV as CSV is a universal and flexible format for records. We wanted the users to be able to model CSV data as quickly as possible without writing new code. This brought us to come up with schema transform system expressed in an ARFF-like vector schema setup as described below.

* Input Format: LineInputFormat
    * org.canova.api.formats.input.impl.LineInputFormat
* Record Schema coming out of input format: { string } 
    * label is defined in vector schema
* Input Files
    * Lines of CSV records in multiple files in a directory
    * Vector schema (described below) will tell the vectorization pipeline how to parse the columns

### Setting up Data For Canova's LineInputFormat To Work with the CSV Vector Schema System

* In the case of the CSV vectorization pipeline in Canova we have an added dimension of a "vector schema" 
* CSV data already has column structure to it so we just tell the system which column is the label (example below)
* We can also express column-level transforms on the CSV data
    * normalize
    * binarize
    * skip
    * label

### Example CSV Configuration File
    
    canova.input.header.skip=false
    canova.input.statistics.debug.print=false
    canova.input.data.type=csv
    canova.input.format=org.canova.api.formats.input.impl.LineInputFormat
    canova.input.directory=src/test/resources/csv/data/uci_iris_sample.txt 
    canova.input.vector.schema=src/test/resources/csv/schemas/uci/iris.txt
    canova.output.vector.format=svmlight
    canova.output.directory=/tmp/iris_unit_test_sample.txt
    canova.output.format=org.canova.api.formats.output.impl.SVMLightOutputFormat

### Example Vector Schema for UCI Iris Dataset (CSV)

    @RELATION UCIIrisDataset
    @DELIMITER ,
       @ATTRIBUTE sepallength  NUMERIC   !NORMALIZE
       @ATTRIBUTE sepalwidth   NUMERIC   !NORMALIZE
       @ATTRIBUTE petallength  NUMERIC   !NORMALIZE
       @ATTRIBUTE petalwidth   NUMERIC   !NORMALIZE
       @ATTRIBUTE class        STRING   !LABEL

## Image Data as Input

* Input Format: ImageInputFormat
    * org.canova.api.formats.input.impl.LineInputFormat
* Record Schema
    * { [array of doubles], directoryLabelID }
    * Description: image data, then the directory indexed as an ID int
* Input Data Setup
    * Directories of image files
    * Each image file represents a unique vector or record
    * The files are broken out into classes or groups by the subdirectory they reside in

### Example Image Configuration File

    canova.input.data.type=image
    canova.input.format=org.canova.image.format.ImageInputFormat
    canova.input.directory=/tmp/canova/image/lfw/
    canova.output.directory=/tmp/canova/image/output/lfw_svmlight_output.txt
    canova.output.format=org.canova.api.formats.output.impl.SVMLightOutputFormat

## Custom Binary Format Data

* Input Format: MnistInputFormat
    * org.canova.image.format.MNISTInputFormat
* Record Schema
    * { [array of doubles], classIndexID }
    * Description: image data, then the class indexed as an ID int from the binary source label files
* Input Data Setup
    * Dependent on custom input format mechanics
    * In the case of MNIST the record reader is parsing out records from the file format described at http://yann.lecun.com/exdb/mnist/

### Example MNIST Custom Input Format Configuration File

    canova.input.format=org.canova.image.format.MNISTInputFormat
    canova.input.directory=/tmp/MNIST/images-idx1-ubyte
    canova.output.vector.format=svmlight
    canova.output.directory=/tmp/mnist_to_svmlight_unit_test.txt
    canova.output.format=org.canova.api.formats.output.impl.SVMLightOutputFormat
