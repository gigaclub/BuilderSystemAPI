package net.gigaclub.buildersystem;

import net.gigaclub.base.odoo.Odoo;
import org.apache.xmlrpc.XmlRpcException;

import java.util.Arrays;

public class BuilderSystem {

    private final Odoo odoo;

    public BuilderSystem(String hostname, String database, String login, String password) {
        this.odoo = new Odoo(hostname, database, login, password);
    }

    // Status Codes:
    // 4: Other error
    // 3: User already in team
    // 2: Team with name already exists
    // 1: Team could not be created
    // 0: Team created successfully
    public int createTeam(String playerUUID, String name) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "create_team", Arrays.asList(playerUUID, name)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 4: Other error
    // 3: User already in team
    // 2: Team with name already exists
    // 1: Team could not be created
    // 0: Team created successfully
    public int createTeam(String playerUUID, String name, String description) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "create_team", Arrays.asList(playerUUID, name, description)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 5: Other error
    // 4: User has no team
    // 3: Team does not exist
    // 2: User is not member of this team
    // 1: User is not manager of this team
    // 0: Success
    public int editTeam(String playerUUID, String name, String newName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "edit_team", Arrays.asList(playerUUID, name, newName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 5;
    }

    // Status Codes:
    // 5: Other error
    // 4: User has no team
    // 3: Team does not exist
    // 2: User is not member of this team
    // 1: User is not manager of this team
    // 0: Success
    public int editTeam(String playerUUID, String name, String newName, String newDescription) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "edit_team", Arrays.asList(playerUUID, name, newName, newDescription)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 5;
    }

    public int leaveTeam(String playerUUID) {
        
    }

}
