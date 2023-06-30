package com.imooc.util;

public class HelloWorld {
    public static void main(String args[]){
         int data [] = new int [] {1,3,2,6,10,0,5,8};   //5个元素
         for(int x = 0;x < data.length;x++){
              for(int y = 0;y < data.length - 1;y++){
                  if(data[y]>data[y+1]){   //后面的小
                       int t = data[y];   //第三方接收 
                       data[y] = data[y+1];
                       data[y+1] = t;
                  }
              }
         }
         print(data);
    }
    public static void print(int temp[]){
          for(int x = 0;x < temp.length;x++){
              System.out.print(temp[x]+"、");
          }
          System.out.println();
    }
}