
package responsi123180125;

import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class PetunjukKaryawan extends JFrame 
{
    JButton btnHome = new JButton("Home");
    JLabel lTampilan = new JLabel("Tombol Gaji Untuk Menghitung Gaji");
    JLabel lTampilan2 = new JLabel("Menu Data untuk Mengecek Data");
    JLabel ljudul = new JLabel("APP PERHITUNGAN GAJI PT Veteran Jaya");
    
    
    public PetunjukKaryawan() 
    {
        setTitle("Petunjuk");
        setDefaultCloseOperation(3);
        setSize(600,500);
        setLayout(null);
        

        add(btnHome);
        add(lTampilan);
        add(lTampilan2);
        add(ljudul);
        btnHome.setBounds(200, 280, 100,30);
        lTampilan.setBounds(150, 100, 200,20);
        lTampilan2.setBounds(150, 120, 300,20);
        ljudul.setBounds(180, 320, 250, 50);
        setVisible(true);
          
        
        btnHome.addActionListener((ActionEvent e) -> {
          new GUI ();
          dispose();
        });
        
        
       
        
       
        
    }
}
