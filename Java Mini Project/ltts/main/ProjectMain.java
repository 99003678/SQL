package com.ltts.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Date;

import com.ltts.model.Player;
import com.ltts.model.Team;
import com.ltts.dao.PlayerDao;
import com.ltts.dao.TeamDao;

public class ProjectMain {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Select your choice:");
		System.out.println("1. Insert \n 2. Search (Retrieve) \n 3. Update the Player and Team \n 4.View all the players \n 5. View all players (based on Team) \n 6. View all players (based on skill & Team)");
	    int n=Integer.parseInt(br.readLine()); 
	    
	    if(n==1)
	    {
	    	System.out.println("1.Insert Player \n 2.Insert Team");
	    	int ins=Integer.parseInt(br.readLine()); 
	    	if(ins==1)
	    	{
	    	System.out.println("Enter the Player Id: "); 
	    	int pid=Integer.parseInt(br.readLine());
	    	System.out.println("Enter the Player Name: ");
            String pname=br.readLine();
            System.out.println("Enter date of birth");
            Date pdob=Date.valueOf(br.readLine());
            System.out.println("Enter the Player skill: ");
            String pskill=br.readLine();
            System.out.println("Enter the Team Id: "); 
	    	int pteamid=Integer.parseInt(br.readLine());
	        System.out.println("Enter the Player Number of Matches: ");
	        int pnum=Integer.parseInt(br.readLine());
	        System.out.println("Enter the Player Wickets: ");
	        int pwic=Integer.parseInt(br.readLine());
	        System.out.println("Enter the Player Nationality: ");
            String pnationality=br.readLine();
	        System.out.println("Enter the Player runs: ");
	        int pruns=Integer.parseInt(br.readLine());
	        
	        Player p=new Player(pid,pname,pdob,pskill,pteamid,pnum,pwic,pnationality,pruns);
	        PlayerDao pd=new PlayerDao();
	        pd.insertPlayer(p);
	    	}
	    	else if(ins==2)
	    	{
	        	
	        System.out.println("Enter the team Id: "); 
	    	int tid=Integer.parseInt(br.readLine());
	    	System.out.println("Enter the Team Name: ");
            String tname=br.readLine();
            System.out.println("Enter the Owner Name: ");
            String towner=br.readLine();
            System.out.println("Enter the Coach Name: ");
            String tcoach=br.readLine();
            System.out.println("Enter the Player Id: "); 
	    	int tteamid=Integer.parseInt(br.readLine());
            
            Team t=new Team(tid,tname,towner,tcoach,tteamid);
	        TeamDao td=new TeamDao();
	        td.insertTeam(t);
	    	}
	    	else
	    	{
	    		System.out.println("Invalid Entry");
		    	System.exit(0);
	    	}
	        
	    }
	    
	    else if(n==2)
	    {
	    	 System.out.println("Enter the Player Id: "); 
		    	int pplayerid=Integer.parseInt(br.readLine());
		    	
	
		    	 PlayerDao pd=new PlayerDao();
			        pd.searchPlayer(pplayerid);
	    }
	    else if(n==3)
	    {
	    	System.out.println("1.Update Player \n 2. Update Team");
	    	int ins1=Integer.parseInt(br.readLine()); 
	    	if(ins1==1)
	    	{
	    		System.out.println("Enter Player name");
	    		String name=br.readLine();
	    		
	    		System.out.println("Enter player ID");
	    		int id=Integer.parseInt(br.readLine());

	    		PlayerDao pd=new PlayerDao();
			        pd.updatePlayer(id,name);
	    	}
	    	else if(ins1==2)
	    	{
	    		System.out.println("Enter Team name");
	    		String name=br.readLine();
	    		
	    		System.out.println("Enter team ID");
	    		int id=Integer.parseInt(br.readLine());
	    		
	    		
	    		TeamDao td=new TeamDao();
			        td.updateTeam(id,name);
	    	}
	    	else
	    	{
	    		System.out.println("Invalid Entry");
		    	System.exit(0);
	    	}
	    }
	    else if(n==4)
	    {
	    	
	    	PlayerDao pd=new PlayerDao();
	        pd.viewAllPlayers();
	    }
	    else if(n==5)
	    {
	    	TeamDao td=new TeamDao();
	        td.viewPlayersTeam();
	    }
	    
	    else if(n==6) 
	    {
	    	TeamDao td=new TeamDao();
	        td.viewPlayersTeamSkill();
	    }
	    else
	    {
	    	System.out.println("Invalid Entry");
	    	System.exit(0);
	    }
	
	}
}