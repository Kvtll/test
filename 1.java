package project1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ListDemo {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int mark=0;
        ArrayList list=new ArrayList<String>();
        ArrayList list1[]=new ArrayList[100];
        for(int i=0;i<100;i++) {
            list1[i]=new ArrayList<String>();
        }
        while(true) {
            int option;
            String str;
            System.out.println("*****************");
            System.out.println("1.入库");
            System.out.println("2.出库");
            System.out.println("3.显示货物");
            System.out.println("4.查找货物");
            System.out.println("5.退出系统");
            System.out.println("*****************");
            System.out.println("要选择的操作:");
            while(true) {
                try {
                    option=Integer.valueOf(scan.nextLine());
                }catch(Exception e) {
                    System.out.println(e.getMessage());
                    continue;
                }
                break;
            }
            switch(option) {
                case 1:{
                    System.out.println("请输入货物类");
                    str=scan.nextLine();
                    boolean button=list.contains(str);
                    int index=list.indexOf(str);
                    if(button) {
                        while(true) {
                            int option1;
                            System.out.println("请输入货物");
                            str=scan.nextLine();
                            list1[index].add(str);
                            System.out.println("是否继续，键入1继续，键入其他中止?");
                            while(true) {
                                try {
                                    option1=Integer.valueOf(scan.nextLine());
                                }catch(NumberFormatException e) {
                                    System.out.println("数值格式错误"+e.getMessage());
                                    continue;
                                }
                                break;
                            }
                            if(option1!=1)
                                break;
                        }
                    }else
                    {
                        int option1;
                        list.add(str);
                        while(true) {
                            System.out.println("请输入货物");
                            while(true) {
                                try {
                                    str=scan.nextLine();
                                }catch(NumberFormatException e) {
                                    System.out.println("数值格式错误"+e.getMessage());
                                    continue;
                                }
                                break;
                            }
                            list1[mark].add(str);
                            System.out.println("是否继续，键入1继续，键入其他中止?");
                            while(true) {
                                try {
                                    option1=Integer.valueOf(scan.nextLine());
                                }catch(NumberFormatException e) {
                                    System.out.println("数值格式错误"+e.getMessage());
                                    continue;
                                }
                                break;
                            }
                            if(option1!=1)
                                break;

                        }
                        mark++;
                    }
                }break;
                case 2:{
                    String str1;
                    int option2;
                    System.out.println("如果要删除的是货物类，键入1，否则键入2");
                    while(true) {
                        try {
                            option2=Integer.valueOf(scan.nextLine());
                        }catch(NumberFormatException e) {
                            System.out.println("数值格式错误"+e.getMessage());
                            continue;
                        }
                        break;
                    }
                    if(option2==1) {
                        System.out.println("请输入要删除的货物类");
                        str1=scan.nextLine();
                        int index=list.indexOf(str1);
                        if(index==-1) {
                            System.out.println("要删除的货物不存在");
                            break;
                        }else {
                            list.remove(str1);
                            list1[index].removeAll(list1[index]);
                        }
                        for(int i=index;i<mark;i++) {
                            list1[i]=list1[i+1];
                        }
                    }else {
                        System.out.println("输入要删除的货物");
                        str1=scan.nextLine();
                        for(int i=0;i<mark;i++) {
                            boolean button=list1[i].remove(str1);
                            if(button==false) continue;
                        }
                    }
                }break;
                case 3:{
                    int i=0;
                    for(int j=1;i<list.size();i++,j++) {
                        String string=(String)list.get(i);
                        System.out.println("货物类编号:"+j);
                        System.out.println("货物类:"+string);
                        Iterator iterator=list1[i].iterator();
                        while(iterator.hasNext()) {

                            String string1=(String) iterator.next();
                            System.out.println("货物编号:"+(list1[i].indexOf(string1)+1)+"   "+"货物:"+string1);
                        }
                    }
                }break;
                case 4:{
                    String string1;
                    System.out.println("请输入查找的货物");
                        string1=scan.nextLine();
                        int i;
                    for(i=0;i<mark;i++) {
                        int jud=list1[i].indexOf(string1);
                        if(jud==-1) continue;
                        else  break;
                    }
                    i=i+1;
                    if(list1[i-1].indexOf(string1)==-1) {
                        System.out.println("要查找的货物不存在");
                        break;
                    }
                    System.out.println("该货物的货物类编号为"+i);
                    System.out.println("该货物的货物编号为"+list1[i-1].indexOf(string1));
                }break;
                case 5:{
                    System.exit(0);
                }
            }
        }
    }
}
