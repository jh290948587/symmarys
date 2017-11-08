package base.sort_arithmetic.dynamic_vector;

import java.util.Vector;

/**
 * Created by Administrator on 2017/8/17.
 */
public class MyVector {
    private Object data[];
//    存储数组中可以容纳的最大的元素个数
    int capacity;
//    存储数组中当前元素个数
    int size;
    public MyVector(){
        data = new Object[10];
        capacity = 10;
        size = 0;
    }
    private void resize(int newCapacity){
        assert newCapacity >= size;
        Object newData[] = new Object[newCapacity];
        for(int i = 0; i < size; i++){
            newData[i] = data[i];
        }
        data = newData;
        capacity = newCapacity;
    }

    public void push_back(Object e){
        if(size == capacity){
            resize(2 * capacity);
        }
        data[size++] = e;
    }

    public Object pop_back(){
        assert size > 0;
//        如果减到数组的当前容量的二分之一，就重新resize,但是会出现复杂度震荡。
//        所以改为四分之一时，删除二分之一的空间
        Object ret = data[size -1];
        size--;
        if(size == capacity/4){
            resize(capacity/2);
        }
        return ret;
    }

}
