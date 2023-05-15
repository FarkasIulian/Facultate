package org.example;

import java.sql.*;
import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Main {

    public static void adaugare_pers(Connection connection, String nume,int varsta){
        String sql = "insert into persoane(nume,varsta) values (?,?)";

        try(PreparedStatement ps =connection.prepareStatement(sql)){
            ps.setString(1,nume);
            ps.setInt(2,varsta);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void adaugare_ex(Statement statement, Connection connection,int id,String destinatie,int an){
        String sql1 = "Select id from persoane where id = " + "'" + id + "'";
        try(ResultSet rs = statement.executeQuery(sql1)){
            if(!rs.first()) {
                System.out.println("ID-ul acesta nu exista in tabela persoane!\n"
                        + "Trebuie adaugata persoana cu acest id prima data!");
                return;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        String sql2 = "Insert into excursii(id_persoana,destinatie,an) values(?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(sql2)){
            ps.setInt(1,id);
            ps.setString(2,destinatie);
            ps.setInt(3,an);
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void afisare(Statement statement,String mesaj){
        String sql = "SELECT p.nume,p.varsta,e.destinatie,e.an FROM persoane p,excursii e WHERE p.id = e.id_persoana";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
                while(rs.next())
                    System.out.println("nume = " + rs.getString(1) + ", varsta = " + rs.getInt(2)
                            + ", destinatie = " + rs.getString(3) + ", an = " + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void excursie(Statement statement,String nume,String mesaj){
        String sql = "SELECT e.destinatie,e.an FROM persoane p,excursii e\n" +
                "WHERE p.nume = '" + nume + "'";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
            while(rs.next())
                System.out.println("Destinatie = " + rs.getString(1) + ", anul = " + rs.getInt(2));
        }catch (SQLException e){
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void persoane(Statement statement,String destinatie,String mesaj){
        String sql = "SELECT p.nume,p.varsta FROM persoane p,excursii e\n" +
                "    WHERE e.destinatie = '" + destinatie + "'";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
            while(rs.next())
                System.out.println("Nume = " + rs.getString(1) + ", varsta = " + rs.getInt(2));
        }catch (SQLException e){
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void excursie_an(Statement statement,int an,String mesaj){
        String sql = "SELECT p.nume,p.varsta FROM persoane p,excursii e\n" +
                "    WHERE e.an = '" + an + "' AND p.id = e.id_persoana";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
            while(rs.next())
                System.out.println("Nume = " + rs.getString(1) + ", varsta = " + rs.getInt(2));
        }catch (SQLException e){
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static  void sterge_ex(Connection connection,int id) {
        String sql = "delete from excursii where id_excursie=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static  void sterge_ex_id(Connection connection,int id) {
        String sql = "delete from excursii where id_persoana=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static  void sterge_pers(Connection connection,int id) {
        sterge_ex_id(connection,id);
        String sql = "delete from persoane where id=?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }

    public static void afisare_persoane(Statement statement,String mesaj){
        String sql = "SELECT * FROM persoane";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
            while(rs.next())
                System.out.println("id = " + rs.getInt(1) + ", nume = " + rs.getString(2)
                        + ", varsta = " + rs.getInt(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void afisare_excursii(Statement statement,String mesaj){
        String sql = "SELECT * FROM excursii";
        System.out.println("\n----"+mesaj+"----");
        try(ResultSet rs = statement.executeQuery(sql)){
            while(rs.next())
                System.out.println("id = " + rs.getInt(1) + ", id_exc = " + rs.getInt(2)
                        + ", destinatie = " + rs.getString(3) + ", an = " + rs.getInt(4));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/lab9";
        Connection connection = DriverManager.getConnection(url,"root","root");
        Statement statement = connection.createStatement();
        Scanner scan = new Scanner(System.in);
        int opt;
        while(true){
            System.out.println("1.Adaugare persoane.");
            System.out.println("2.Adaugare excursii.");
            System.out.println("3.Afisare persoane + excursii.");
            System.out.println("4.Afisare excursii persoana.");
            System.out.println("5.Persoane care au fost intr-o destinatie.");
            System.out.println("6.Persoane care au facut excursii intr-un anumit an");
            System.out.println("7.Stergere excursie.");
            System.out.println("8.Stergere persoana");
            System.out.println("9.Afisare toate.");
            System.out.println("0.Iesire.");
            System.out.println("Introduceti optiunea: ");
            opt = Integer.parseInt(scan.nextLine());
            switch (opt) {
                case 0:
                    exit(0);
                case 1:
                    String nume;
                    int varsta;
                    System.out.println("Introduceti un nume: ");
                    nume = scan.nextLine();
                    System.out.println("Introduceti varsta: ");
                    varsta = Integer.parseInt(scan.nextLine());
                    adaugare_pers(connection, nume, varsta);
                    break;
                case 2:
                    String destinatie;
                    int id,an;
                    System.out.println("Introduceti id-ul: ");
                    id = Integer.parseInt(scan.nextLine());
                    System.out.println("Introduceti destinatia: ");
                    destinatie = scan.nextLine();
                    System.out.println("Introduceti anul: ");
                    an = Integer.parseInt(scan.nextLine());
                    adaugare_ex(statement,connection,id,destinatie,an);
                    break;
                case 3:
                    afisare(statement,"Persoane + excursii");
                    break;
                case 4:
                    String nume_cautat;
                    nume_cautat = scan.nextLine();
                    excursie(statement,nume_cautat,"Excursii");
                    break;
                case 5:
                    String destinatie_cautata;
                    destinatie_cautata = scan.nextLine();
                    persoane(statement,destinatie_cautata,"Persoane");
                    break;
                case 6:
                    int an_cautat;
                    an_cautat = Integer.parseInt(scan.nextLine());
                    excursie_an(statement,an_cautat,"Persoane");
                    break;
                case 7:
                    int id_exc;
                    id_exc = Integer.parseInt(scan.nextLine());
                    sterge_ex(connection,id_exc);
                    break;
                case 8:
                    int id_pers;
                    id_pers = Integer.parseInt(scan.nextLine());
                    sterge_pers(connection,id_pers);
                case 9:
                    afisare_persoane(statement,"Persoane");
                    afisare_excursii(statement,"Excursii");
            }
        }
    }
}