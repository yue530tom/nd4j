package org.nd4j.linalg.api.memory.pointers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.*;

/**
 * @author raver119@gmail.com
 */
@Slf4j
public class PagedPointer extends Pointer {

    // we're storing this pointer as strong reference
    @Getter
    private Pointer originalPointer;
    @Getter
    @Setter
    private boolean leaked = false;

    private PagedPointer() {

    }

    public PagedPointer(Pointer pointer) {
        this.originalPointer = pointer;

        this.address = pointer.address();

        this.capacity = pointer.capacity();
        this.limit = pointer.limit();
        this.position = 0;
    }

    public PagedPointer(Pointer pointer, long capacity) {
        this.originalPointer = pointer;

        this.address = pointer.address();

        this.capacity = capacity;
        this.limit = capacity;
        this.position = 0;
    }

    public PagedPointer(Pointer pointer, long capacity, long offset) {
        this.address = pointer.address() + offset;

        this.capacity = capacity;
        this.limit = capacity;
        this.position = 0;
    }


    public PagedPointer withOffset(long offset, long capacity) {
        return new PagedPointer(this, capacity, offset);
    }


    public FloatPointer asFloatPointer() {
        return new ImmortalFloatPointer(this);
    }

    public DoublePointer asDoublePointer() {
        return new DoublePointer(this);
    }

    public IntPointer asIntPointer() {
        return new IntPointer(this);
    }

    public LongPointer asLongPointer() {
        return new LongPointer(this);
    }

    @Override
    public void deallocate() {
        super.deallocate();
    }

    @Override
    public void deallocate(boolean deallocate) {
        super.deallocate(true);
    }
}
