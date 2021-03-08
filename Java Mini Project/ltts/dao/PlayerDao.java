package com.ltts.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ltts.config.MyConnection;
import com.ltts.model.Player;

public class PlayerDao {

	public List<Player> getAllPlayers()
	{
		List<Player> li=new ArrayList<Player>();
		
		return li;
		}
		
		public Player getPlayerById(int id) {
			Player p = new Player();
				
			return p;
		}
		
			public boolean insertPlayer(Player p) throws Exception
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps= c.prepareStatement("insert into player values(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, p.getPlayerId());
				ps.setString(2, p.getPlayerName());
				ps.setDate(3, (Date) p.getDateOfBirth());
				ps.setString(4, p.getSkills());
				ps.setInt(5, p.getTeamId());
				ps.setInt(6, p.getNumberOfMatches());
				ps.setInt(7, p.getWickets());
				ps.setString(8, p.getNationality());
				ps.setInt(9, p.getRuns());
				return ps.execute();
			}
			
			public void searchPlayer(int id) throws Exception
			{
				//Config c=new Config();
				Connection con=MyConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("Select p.playerName,t.teamName,t.coachName,TIMESTAMPDIFF(YEAR, dateOfBirth, CURDATE()) AS age from player as p inner join team as t on p.playerId=t.playerId where p.playerId=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
					String name=rs.getString(1);
					String n=rs.getString(2);
					String cn=rs.getString(3);
					String age=rs.getString(4);
					System.out.println(name+" "+n+" "+cn+" "+age);
					
				}
			}
			public void viewAllPlayers() throws Exception
			{
				Connection con=MyConnection.getConnection();
				PreparedStatement ps=con.prepareStatement("Select * from player");
				ResultSet rs=ps.executeQuery();
				while(rs.next())
				{
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String dob=rs.getString(3);
				String skills=rs.getString(4);
				int teamid=rs.getInt(5);
				int noofmatches=rs.getInt(6);
				int wickets=rs.getInt(7);
				String nationality=rs.getString(8);
				int runs=rs.getInt(9);
				System.out.println(id+" "+name+" "+dob +" "+skills+" "+teamid+" "+noofmatches +" "+wickets+" "+nationality+" "+runs +" ");
				}
			}
			public boolean updatePlayer(int id,String name) throws Exception
			{
				Connection c= MyConnection.getConnection();
				PreparedStatement ps= c.prepareStatement("UPDATE player SET playerName=? WHERE playerId=?");
				ps.setString(1, name);
				ps.setInt(2, id);
			
				
				return ps.execute();
			}

				
	}