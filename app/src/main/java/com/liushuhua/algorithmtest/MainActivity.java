package com.liushuhua.algorithmtest;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

public class MainActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.sort).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sort:
                插入排序();
                冒泡排序();
                简单排序();
                希尔排序();
                break;
        }
    }

    private void 希尔排序() {
        int[] array = new int[]{5, 2, 0, 1, 3, 1, 4};
        for (int n = array.length, d = n / 2; d > 0; d /= 2) {//取增量为长度的一半，每次减半，直到d=1，但是d=1必须得排序，因此最后的判断为d>0
            for (int x = 0; x < d; x++) {//分组
                for (int i = x + d; i < n; i += d) {//每组进行直接插入排序
                    int temp = array[i];
                    int j = i - d;
                    for (; j >= 0 && array[j] > temp; j = j - d) {
                        array[j + d] = array[j];
                    }
                    array[j + d] = temp;
                }
            }
        }
        Log.i(TAG, "希尔排序: " + Arrays.toString(array));
    }

    private void 冒泡排序() {
        int[] array = new int[]{2, 5, 0, 1, 3, 1, 4};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = array.length - 1 - 1; j >= i; j--) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }

        }
        Log.i(TAG, "冒泡排序: " + Arrays.toString(array));
    }

    private void 插入排序() {
        int[] array = new int[]{2, 5, 0, 1, 3, 1, 4};
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0 && temp < array[j]; j--) {
                array[j + 1] = array[j];
            }
            array[j + 1] = temp;
        }
        Log.i(TAG, "插入排序: " + Arrays.toString(array));
    }

    private void 简单排序() {
        int[] array = new int[]{2, 5, 0, 1, 3, 1, 4};
        for (int i = 0; i < array.length; i++) {
            int j = i + 1;
            int temp = array[i];
            int index = i;
            for (; j < array.length; j++) {
                if (array[j] < temp) {
                    temp = array[j];
                    index = j;
                }
            }
            array[index] = array[i];
            array[i] = temp;
        }
        Log.i(TAG, "简单排序: " + Arrays.toString(array));
    }

}
