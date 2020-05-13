
package responsi123180125;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;


public class Data extends JFrame  {
    
     static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/responsi_db";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;

    JButton btnHome = new JButton("Home");
      JButton btnGaji = new JButton("Gaji");
      JButton btnData = new JButton("Data");
       JButton btnPetunjuk = new JButton("Petunjuk");
        JButton btnAdmin = new JButton("Admin");
        
         JTable table;
        DefaultTableModel tableModel;
        JScrollPane scrollPane;
        Object namaKolom[] = {"ID Karyawan","Nama","Posisi","Alamat","No HP","Gaji Pokok","Jam Lembur","Tunjangan","Pajak","Total"};
        
         public Data() {
             
             
              try{
                    Class.forName(JDBC_DRIVER);
                    koneksi = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
                    System.out.println("Koneksi Berhasil");
                }catch(ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                    System.out.println("Koneksi Gagal");
                }   
            
            tableModel = new DefaultTableModel(namaKolom,0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Data");
        setDefaultCloseOperation(3);
        setSize(960,460);

        setLayout(null);

        add(btnHome);
        btnHome.setBounds(10, 10, 100,30);
        add(btnGaji);
        btnGaji.setBounds(10, 45, 100,30);
        add(btnData);
        btnData.setBounds(10, 80, 100,30);
        add(btnPetunjuk);
        btnPetunjuk.setBounds(10, 115, 100,30);
        add(btnAdmin);
        btnAdmin.setBounds(800,10, 100,30);
        
       
        add(scrollPane);
        scrollPane.setBounds(140,70,760,200);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
       
         
        setVisible(true);
          
        if (this.getBanyakData() != 0) { 
                    String datagaji[][] = this.readGaji(); 
                    table.setModel((new JTable(datagaji, namaKolom)).getModel());
                } else {
                    JOptionPane.showMessageDialog(null, "Data Tidak Ada");
                }
        
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
           new PetunjukAdmin();
           dispose();
        });

    }
          int getBanyakData() {
                int jmlData = 0;
                try{
                    statement = koneksi.createStatement();
                    String query = "SELECT * from `gaji`";
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        jmlData++;
                    }
                    return jmlData;
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    System.out.println("SQL error");
                    return 0;
                }
            }
          
String[][] readGaji() {
                try{
                    int jmlData = 0;
                    String data[][]=new String[getBanyakData()][10];
                    String query = "Select * from `gaji`";
                    ResultSet resultSet = statement.executeQuery(query);
                    while(resultSet.next()){
                        data[jmlData][0] = resultSet.getString("id");
                        data[jmlData][1] = resultSet.getString("nama");
                        data[jmlData][2] = resultSet.getString("posisi");
                        data[jmlData][3] = resultSet.getString("alamat");
                        data[jmlData][4] = resultSet.getString("telp");
                        data[jmlData][5] = resultSet.getString("gajipokok");
                        data[jmlData][6] = resultSet.getString("jamlembur");
                        data[jmlData][7] = resultSet.getString("tunjangan");
                        data[jmlData][8] = resultSet.getString("pajak");
                        data[jmlData][9] = resultSet.getString("total");
                        jmlData++;
                    }
                    return data;
                }catch(SQLException e){
                    System.out.println(e.getMessage());
                    System.out.println("SQL error");
                    return null;
                }
            }
}
