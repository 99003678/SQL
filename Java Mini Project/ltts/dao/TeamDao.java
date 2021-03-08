package com.ltts.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ltts.config.MyConnection;
import com.ltts.model.Team;

public class TeamDao {

	public List<Team> getAllTeams(){
		List<Team> li=new ArrayList<Team >();
		
		return li;
		}
	public Team getTeamById(int id) {
		Team t = new Team();
			
		return t;
	}
	public boolean insertTeam(Team t) throws Exception
	{
		Connection c= MyConnection.getConnection();
		
		PreparedStatement ps= c.prepareStatement("insert into team values(?,?,?,?,?)");
		ps.setInt(1,t.getTeamId());
		ps.setString(2, t.getTeamName());
		ps.setString(3, t.getOwnerName());
		ps.setString(4, t.getCoachName());
		ps.setInt(5,t.getPlayerId());
		
		return ps.execute();
}
	public void viewPlayersTeam() throws Exception
	{
		Connection con=MyConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from player order by nationality");
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
	public void viewPlayersTeamSkill() throws Exception
	{
		Connection con=MyConnection.getConnection();
		PreparedStatement ps=con.prepareStatement("Select * from player order by nationality,skills");
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
	public boolean updateTeam(int id,String name) throws Exception
	{
		Connection c= MyConnection.getConnection();
		PreparedStatement ps= c.prepareStatement("UPDATE team SET teamName=? WHERE teamId=?");
		ps.setString(1, name);
		ps.setInt(2, id);
		return ps.execute();
	}
 
}