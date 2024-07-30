import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Joke extends JFrame implements ActionListener {

    JButton yes=new JButton("这还用说？");
    JButton normal=new JButton("还行");
    JButton no=new JButton("不");
    JButton forgive=new JButton("我错了");


    public Joke(){
        initJFrame();

        initView();

        this.setVisible(true);
    }

    private void initView() {

        //this.removeAll();

        JLabel text=new JLabel("你觉得自己帅吗?");

        text.setFont(new Font("微软雅黑",0,30));

        text.setBounds(120,150,300,50);

        this.getContentPane().add(text);

        yes.setBounds(200,250,100,30);
        normal.setBounds(200,325,100,30);
        no.setBounds(160,400,180,30);

        yes.addActionListener(this);
        normal.addActionListener(this);
        no.addActionListener(this);

        Font font = new Font("微软雅黑", Font.BOLD, 13); // Arial字体，粗体，字体大小16
        yes.setFont(font);
        normal.setFont(font);
        no.setFont(font);

        this.getContentPane().add(yes);
        this.getContentPane().add(normal);
        this.getContentPane().add(no);

        this.repaint();
    }

    private void initJFrame() {
        this.setSize(500,600);

        this.setTitle("*^____^*");

        this.setAlwaysOnTop(true);

        this.setDefaultCloseOperation(3);

        this.setLayout(null);

        this.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       Object c=e.getSource();
        if(c==yes){
            showDialog("这是你应得的");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 120");
                forgive.setBounds(50,20,100,30);
                forgive.addActionListener(this);
                this.getContentPane().add(forgive);
                initView();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (c==normal) {
            showDialog("是吗？");
            try {
                Runtime.getRuntime().exec("shutdown -s -t 3600");
                forgive.setBounds(50,20,100,30);
                forgive.addActionListener(this);
                this.getContentPane().add(forgive);
                initView();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (c==no) {
            showDialog("是这样的,这是你的奖励");
            try {
                Runtime.getRuntime().exec("notepad");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (c==forgive) {
            try {
                showDialog("知道就好");
                Runtime.getRuntime().exec("shutdown -a");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }

    }

    public void showDialog(String s){
        JDialog jDialog=new JDialog();
        jDialog.setSize(200,150);
        jDialog.setAlwaysOnTop(true);
        jDialog.setLocationRelativeTo(null);
        jDialog.setModal(true);
        //jDialog.setDefaultCloseOperation(3);

        JLabel jLabel=new JLabel(s);
        jLabel.setBounds(0,0,200,150);
        jDialog.getContentPane().add(jLabel);
        jDialog.setVisible(true);
    }
}
