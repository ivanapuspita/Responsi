

//IVANA PUSPITA SARI
//123180125
//Plug F
package responsi123180125;

import java.awt.event.ActionEvent;
import javax.swing.*;


public class Main {

    public static void main(String[] args) {
        new Tampil(); 
    }
}

class GUI extends JFrame {
    JButton btnHome = new JButton("Home");
    JButton btnGaji = new JButton("Gaji");
    JButton btnData = new JButton("Data");
    JButton btnPetunjuk = new JButton("Petunjuk");
    JButton btnAdmin = new JButton("Admin");
    JLabel ltext = new JLabel("Selamat Datang");
    JLabel ltext2 = new JLabel("Masuk Menu Gaji untuk Perhitungan");
    JLabel ltext3 = new JLabel("Menu Petunjuk Jika Anda Kesulitan");
    JLabel ltext4 = new JLabel("APP PERHITUNGAN GAJI PT Veteran Jaya");
    public GUI() {
    setTitle("Gaji");
    setDefaultCloseOperation(3);
    setSize(600,500);
    setLayout(null);
        

        add(btnHome);
        btnHome.setBounds(10, 30, 100,30);
        add(btnGaji);
        btnGaji.setBounds(10, 85, 100,30);
        add(btnData);
        btnData.setBounds(10, 120, 100,30);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10, 165, 100,30);
        add(btnAdmin);
        btnAdmin.setBounds(470,10, 100,30);
        
        add(ltext);
        ltext.setBounds(150, 100, 200,20);
        add(ltext2);
        ltext2.setBounds(150, 120, 300,20);
        add(ltext3);
        ltext3.setBounds(150, 140, 200,20);
        add(ltext4);
        ltext4.setBounds(180, 320, 250,80);
        
        setVisible(true);
          
        
        btnHome.addActionListener((ActionEvent e) -> {
          new GUI();
           dispose();
        });
        btnGaji.addActionListener((ActionEvent e) -> {
           new Gaji();
           dispose();
           });
       
        btnData.addActionListener((ActionEvent e) -> {
           new Data();
           dispose();
        });
        
        btnPetunjuk.addActionListener((ActionEvent e) -> {
           new PetunjukKaryawan();
           dispose();
        });
        btnAdmin.addActionListener((ActionEvent e) -> {
           new Login();
           dispose();
        });
        
        
       
        
       
        
    }
}