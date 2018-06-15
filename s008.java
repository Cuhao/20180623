import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class s008 extends JFrame{
    Container cp;
    private int op=0;
    JLabel jLabel1 =new JLabel();
    JLabel jLabel2 =new JLabel();
    JLabel jLabel3 =new JLabel();
    ImageIcon imageIcon1 =new ImageIcon("哨塔.png");
    ImageIcon imageIcon2 =new ImageIcon("激光砲.png");
    ImageIcon imageIcon3 =new ImageIcon("反轉哨塔.png");
    ImageIcon imageIcon4 =new ImageIcon("反轉激光砲.png");
    Timer t1 ;
    Timer t2 ;
    private int iconx =0;
    private int icony =100;



    public  s008(){init();}

    private void init(){
        cp=this.getContentPane();
        cp.setLayout(null);

        this.setBounds(10,10,600,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.add(jLabel1);


        jLabel1.setIcon(imageIcon1);


        Image img =imageIcon1.getImage();
        Image img2=img.getScaledInstance(100,120,Image.SCALE_SMOOTH);
        imageIcon1.setImage(img2);
        img =imageIcon2.getImage();
        img2=img.getScaledInstance(120,50,Image.SCALE_SMOOTH);
        imageIcon2.setImage(img2);
        img =imageIcon3.getImage();
        img2=img.getScaledInstance(100,120,Image.SCALE_SMOOTH);
        imageIcon3.setImage(img2);
        img =imageIcon4.getImage();
        img2=img.getScaledInstance(120,50,Image.SCALE_SMOOTH);
        imageIcon4.setImage(img2);




        jLabel1.setSize(100,120);
        jLabel2.setSize(120,50);
        jLabel3.setSize(100,120);


        jLabel1.setLocation(iconx,icony);
        jLabel3.setLocation(jLabel1.getX(),jLabel1.getY());


        jLabel1.setIcon(imageIcon1);
        jLabel2.setIcon(imageIcon2);
        jLabel3.setIcon(imageIcon3);
        t1=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jLabel2.setLocation(jLabel2.getX()+5,jLabel2.getY());

            }
        });
        t2=new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                jLabel2.setLocation(jLabel2.getX()-5,jLabel2.getY());
            }
        });

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent keyEvent) {
                switch (keyEvent.getKeyCode()){
                    case 38:
                        jLabel1.setLocation(jLabel1.getX(),jLabel1.getY()-5);
                        break;
                    case 40:
                        jLabel1.setLocation(jLabel1.getX(),jLabel1.getY()+5);
                        break;
                    case 37:

                        jLabel1.setIcon(imageIcon3);
                        jLabel1.setLocation(jLabel1.getX()-5,jLabel1.getY());
                        op=1;


                        break;
                    case 39:
                        jLabel1.setIcon(imageIcon1);
                        jLabel1.setLocation(jLabel1.getX()+5,jLabel1.getY());
                        op=0;

                        break;
                    case 32:

                        cp.add(jLabel2);
                        if (op==0) {
                            jLabel2.setIcon(imageIcon2);
                            t2.stop();
                            t1.start();
                            jLabel2.setLocation(jLabel1.getX(), jLabel1.getY() + 40);
                        }else {
                            t1.stop();
                            jLabel2.setIcon(imageIcon4);
                            jLabel2.setLocation(jLabel1.getX(), jLabel1.getY() + 40);
                            t2.start();
                        }
                        break;
                }
                System.out.println(keyEvent.getKeyCode());
            }
        });
        //38上37左
        //40下39右
    }
}
