package com.lsf.twnb.serialize;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: liusf13201
 * @DATE: 2016/7/20
 *
 */
public class Node {

    private int value;
    public Node next;
    public Node(int value){
        this.value=value;
    }
    public  boolean hasCircle(){
        Node slow=this;
        Node fast=this.next.next;
        while(slow!=null&&fast!=null&&fast.next!=null){
            System.out.println(fast.value+"|"+slow.value);
            if(fast==slow){
                return true;
            }else{
                slow=slow.next;
                fast=fast.next.next;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        Node node1=new Node(1);
        Node node2=new Node(2);
        Node node3=new Node(3);
        Node node4=new Node(4);
        Node node5=new Node(5);
        Node node6=new Node(6);
        Node node7=new Node(7);
        Node node8=new Node(8);
        node1.next=node2;
        node2.next=node3;
        node4.next=node5;
        node5.next=node6;
        node6.next=node7;
        node7.next=node8;
        node8.next=node1;
        System.out.println(node1.hasCircle());
    }


}
