import java.util.Scanner;

public class NoteBook {
    String[] notes = new String[1000];
    int count;

    //构造方法
    NoteBook()
    {
        count = 0;
    }

    //添加存储信息
    public void addNote()
    {
        count++;
        System.out.println("请输入需要添加存储的信息：");
        Scanner input = new Scanner(System.in);
        String str = input.next();
        notes[count] = str;
        System.out.println("添加成功！");
    }

    //打印存储信息
    public void getNotes()
    {
        for(int i=1;i<=count;i++)
        {
            System.out.println("No." + i + " : " + notes[i]);
        }
    }

    //返回存储信息的数量
    public int getCount()
    {
        return count;
    }

    //删除某条存储的信息
    public void removeNote(int num)
    {
        if(num>count){
            System.out.println("不存在此条信息！");
        }else{
            int i = num;
            while (i<=count) {
                notes[i] = notes[i+1];
                i++;
            }
            count--;
            System.out.println("删除成功！");
        }
    }

    //打印菜单
    public static void printMenu()
    {
        System.out.println("====================");
        System.out.println("请选择服务：");
        System.out.println("1、存储记录\n2、显示记录\n3、显示当前存储信息的数量\n4、删除指定记录\n5、退出");
    }

    public static void main(String[] args)
    {
        int choice = 0;
        NoteBook note = new NoteBook();
        do {
            printMenu();
            Scanner input = new Scanner(System.in);
            choice = input.nextInt();
            switch (choice)
            {
                case 1:
                    note.addNote();
                    break;
                case 2:
                    note.getNotes();
                    break;
                case 3:
                    System.out.println("共有 " + note.getCount() + " 条记录");
                    break;
                case 4:
                    System.out.println("请选择删除哪一条记录");
                    int num = input.nextInt();
                    note.removeNote(num);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("请输入正确的数字:");
            }
        }while(choice != 5);
    }
}
