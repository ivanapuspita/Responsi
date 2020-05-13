
package responsi123180125;

import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import javax.swing.JOptionPane;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Update extends JFrame {
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement; 
    Create enter;
    JLabel lIdkaryawan = new JLabel("ID Karyawan");
    JTextField tfIdkaryawan = new JTextField();
    JLabel lNama= new JLabel("Nama");
    JTextField tfNama = new JTextField();
    JLabel lPosisi = new JLabel("Posisi");
    JTextField tfPosisi = new JTextField();
    JLabel lAlamat = new JLabel("Alamat ");
    JTextField tfAlamat = new JTextField();
    JLabel lNohp= new JLabel("No HP");
    JTextField tfNohp = new JTextField();
    JLabel lTotal = new JLabel("Total");
    JTextField tfTotal = new JTextField();
    JButton btnHome = new JButton("Home");
    JButton btnGaji = new JButton("Tambah");
    JButton btnData = new JButton("Data");
    JButton btnPetunjuk = new JButton("Petunjuk");
    JButton btnAdmin = new JButton("Karyawan");
    JButton btnSimpan = new JButton("Simpan");
    
    
    public Update(){
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
        setSize(750, 500);

        
        setTitle("Tambah");
        
        add(lIdkaryawan);
        lIdkaryawan.setBounds(150, 30, 100,20);
        add(tfIdkaryawan);
        tfIdkaryawan.setBounds(250, 30, 100,20);
        
        add(lNama);
        lNama.setBounds(150, 60, 100,20);
        add(tfNama);
        tfNama.setBounds(250, 60, 100,20);        
        
        add(lPosisi);
        lPosisi.setBounds(150, 90, 100,20);
        add(tfPosisi);
        tfPosisi.setBounds(250, 90, 100,20);
        
        add(lAlamat);
        lAlamat.setBounds(150, 120, 100,20);
        add(tfAlamat);
        tfAlamat.setBounds(250, 120, 200,20);
        
        add(lNohp);
        lNohp.setBounds(150, 150, 150,20);
        add(tfNohp);
        tfNohp.setBounds(250, 150, 150,20);
        
        add(lTotal);
        lTotal.setBounds(150, 180, 100,20);
        add(tfTotal);
        tfTotal.setBounds(250, 180, 100,20);


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
                    if (tfIdkaryawan.getText().equals("") ) {
                        JOptionPane.showMessageDialog(null, "Field tidak boleh kosong");
                    } else {
                     
                  
                       String id = tfIdkaryawan.getText();
                        String nama = tfNama.getText();
                         String posisi = tfPosisi.getText();
                         String alamat = tfAlamat.getText();
                        String telp = tfNohp.getText();
                        String total = tfTotal.getText();
                       
                        this.insertGaji(id, nama, posisi, alamat, telp, total);

                                           
                    }
                });

         
        
    }
    
    public String getIdkaryawan(){
        return tfIdkaryawan.getText();
    } 
    
    public void insertGaji (String id, String nama, String posisi, String alamat, String telp,  String total) {
                try{
                    String query = "INSERT INTO `karyawan`(`idkar`,`namakar`,`posisikar`,`alamatkar`,`telpkar`,`totalkar`) VALUES "
                            + "('"+id+"','"+nama+"','"+posisi+"','"+alamat+"','"+telp+"','"+total+"')";
                statement = (Statement) koneksi.createStatement();
                statement.executeUpdate(query);
                System.out.println("Berhasil Ditambahkan");
                JOptionPane.showMessageDialog(null,"data berhasil ditambahkan");
                }catch(Exception sql){
                    System.out.println(sql.getMessage());
                    JOptionPane.showMessageDialog(null, sql.getMessage());
                }

            }



}
    
