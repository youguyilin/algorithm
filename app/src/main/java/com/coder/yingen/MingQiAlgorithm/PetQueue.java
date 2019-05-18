package com.coder.yingen.MingQiAlgorithm;

/**
 * PackageName: com.coder.yingen.MingQiAlgorithm
 * ClassName: PetQueue
 * Author: chuyingen
 * Date: 2019-05-09 15:32
 * Description:
 */
public class PetQueue {
    private Pet mPet;
    private long count; //加入时的时间戳

    public PetQueue(Pet pet, long count) {
        mPet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return mPet;
    }

    public long getCount() {
        return count;
    }

    public String getEnterType(){
        return this.mPet.getType();
    }
}
