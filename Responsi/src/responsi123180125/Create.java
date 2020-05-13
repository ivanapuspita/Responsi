
package responsi123180125;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class Create extends JFrame {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_db";
    static final String USER = "root";
    static final String PASS = "";

    Connection koneksi;
    Statement statement; 
    Create enter;
    
    JLabel lid = new JLabel("ID Karyawan");
    JTextField tfid = new JTextField();
    JLabel lnama= new JLabel("Nama");
    JTextField tfnama = new JTextField();
    JLabel lposisi = new JLabel("Posisi");
    JTextField tfposisi = new JTextField();
    JLabel lalamat = new JLabel("Alamat ");
    JTextField tfalamat = new JTextField();
    JLabel ltelp= new JLabel("Telepon");
    JTextField tftelp = new JTextField();
    JLabel ltotal = new JLabel("Total");
    JTextField tftotal = new JTextField();
      
    JButton btnHome = new JButton("Home");
    JButton btnGaji = new JButton("Tambah");
    JButton btnData = new JButton("Data");
    JButton btnPetunjuk = new JButton("Petunjuk");
    JButton btnAdmin = new JButton("Karyawan");
    JButton btnSimpan = new JButton("Simpan");
    
    public Create(){
        try{
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            System.out.println("Koneksi Berhasil");
        }catch(ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
            }  

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(750, 460);
        setTitle("Tambah");
        
        add(lid);
        lid.setBounds(150, 30, 100,20);
        add(tfid);
        tfid.setBounds(250, 30, 100,20);
        
        add(lnama);
        lnama.setBounds(150, 60, 100,20);
        add(tfnama);
        tfnama.setBounds(250, 60, 100,20);        
        
        add(lposisi);
        lposisi.setBounds(150, 90, 100,20);
        add(tfposisi);
        tfposisi.setBounds(250, 90, 100,20);
        
        add(lalamat);
        lalamat.setBounds(150, 120, 100,20);
        add(tfalamat);
        tfalamat.setBounds(250, 120, 200,20);
        
        add(ltelp);
        ltelp.setBounds(150, 150, 150,20);
        add(tftelp);
        tftelp.setBounds(250, 150, 150,20);
        
        add(ltotal);
        ltotal.setBounds(150, 180, 100,20);
        add(tftotal);
        tftotal.setBounds(250, 180, 100,20);
        add(btnHome);
        btnHome.setBounds(10, 10, 100,30);
        add(btnGaji);
        btnGaji.setBounds(10, 45, 100,30);
        add(btnData);
        btnData.setBounds(10, 80, 100,30);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10, 115, 100,30);
        add(btnAdmin);
        btnAdmin.setBounds(570,10, 100,30);
        add(btnSimpan);
        btnSimpan.setBounds(570,335, 100,30);
        
        btnHome.addActionListener((ActionEvent e) -> {
            new Tampil();
            dispose();
        });
        
        btnGaji.addActionListener((ActionEvent e) -> {
            new Create();
            dispose();
        });
       
        btnData.addActionListener((ActionEvent e) -> {
           new Karyawan();
           dispose();
        });
        
        btnPetunjuk.addActionListener((ActionEvent e) -> {
           new PetunjukKaryawan();
           dispose();
        });
       
        btnSimpan.addActionListener((ActionEvent e) -> {
            if (tfid.getText().equals("") ) {
                JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
            } else {
                String id = tfid.getText();
                String nama = tfnama.getText();
                String posisi = tfposisi.getText();
                String alamat = tfalamat.getText();
                String telp = tftelp.getText();
                String total = tftotal.getText();
                this.insertGaji(id, nama, posisi, alamat, telp, total);
            }
        });

    
    }
    
    public String getIdkaryawan(){
        return tfid.getText();
    } 

    public void insertGaji (String id, String nama, String posisi, String alamat, String telp,  String total) {
                try{
                    String query = "INSERT INTO `karyawan`(`idkar`,`namakar`,`posisikar`,`alamatkar`,`telpkar`,`totalkar`) VALUES"
                            + " ('"+id+"','"+nama+"','"+posisi+"','"+alamat+"','"+telp+"','"+total+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Data Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"data berhasil ditambahkan");
                }catch(Exception sql){
                    System.out.println(sql.getMessage());
                    JOptionPane.showMessageDialog(null, sql.getMessage());
                }

            }

}
    
