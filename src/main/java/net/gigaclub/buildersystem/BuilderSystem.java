package net.gigaclub.buildersystem;

import net.gigaclub.base.odoo.Odoo;
import org.apache.xmlrpc.XmlRpcException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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

    // Status Codes:
    // 2: Other error
    // 1: User has no team
    // 0: Success
    public int leaveTeam(String playerUUID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "leave_team", Arrays.asList(playerUUID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 2;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is not user of this team
    // 0: Success
    public int addMember(String playerUUID, String playerUUIDtoAdd) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "add_member", Arrays.asList(playerUUID, playerUUIDtoAdd)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is already member of this team
    // 0: Success
    public int inviteMember(String playerUUID, String playerUUIDtoInvite) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "invite_member", Arrays.asList(playerUUID, playerUUIDtoInvite)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 3: Other error
    // 2: Team does not exist
    // 1: Request does not exist
    // 0: Success
    public int acceptRequest(String playerUUID, String teamName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "accept_request", Arrays.asList(playerUUID, teamName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 3;
    }

    // Status Codes:
    // 3: Other error
    // 2: Team does not exist
    // 1: Request does not exist
    // 0: Success
    public int denyRequest(String playerUUID, String teamName) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "deny_request", Arrays.asList(playerUUID, teamName)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 3;
    }

    // Status Codes:
    // 4: Other error
    // 3: Team does not exist
    // 2: User is not manager
    // 1: User is not user of this team
    // 0: Success
    public int kickMember(String playerUUID, String playerUUIDtoKick) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "kick_member", Arrays.asList(playerUUID, playerUUIDtoKick)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 6: Other error
    // 5: Team does not exist
    // 4: User is not manager
    // 3: User to kick is not a team
    // 2: User to kick is not in this team
    // 1: User is already manager of this team
    // 0: Success
    public int promoteMember(String playerUUID, String playerUUIDtoPromote) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "promote_member", Arrays.asList(playerUUID, playerUUIDtoPromote)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 6;
    }

    // Status Codes:
    // 6: Other error
    // 5: Team does not exist
    // 4: User is not manager
    // 3: User to kick is not a team
    // 2: User to kick is not in this team
    // 1: User is already user of this team
    // 0: Success
    public int demoteMember(String playerUUID, String playerUUIDtoDemote) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "demote_member", Arrays.asList(playerUUID, playerUUIDtoDemote)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 6;
    }

    public Map<String, String> getTeamNameByMember(String playerUUID) {
        try {
            return (Map<String, String>) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_team_by_member", Arrays.asList(playerUUID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] getAllTeams() {
        try {
            return (Object[]) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_all_teams", Arrays.asList()
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getTeam(String name) {
        try {
            return this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.team", "get_team", Arrays.asList(name)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int createTask(String name) {
        return this.odoo.create("project.task", Arrays.asList(new HashMap<>() {{
            put("name", name);
        }}));
    }

    public int createTask(String name, String description) {
        return this.odoo.create("project.task", Arrays.asList(new HashMap<>() {{
            put("name", name);
            put("description", description);
        }}));
    }

    public int createTask(String name, String description, int buildWidth, int buildLength) {
        return this.odoo.create("project.task", Arrays.asList(new HashMap<>() {{
            put("name", name);
            put("description", description);
            put("build_width", buildWidth);
            put("build_length", buildLength);
        }}));
    }

    public void removeTask(int id) {
        this.odoo.unlink("project.task", Arrays.asList(Arrays.asList(id)));
    }

    public void editTaskName(int id, String newName) {
        this.odoo.write("project.task", Arrays.asList(Arrays.asList(id), new HashMap<>() {{
            put("name", newName);
        }}));
    }

    public void editTaskDescription(int id, String newDescription) {
        this.odoo.write("project.task", Arrays.asList(Arrays.asList(id), new HashMap<>() {{
            put("description", newDescription);
        }}));
    }

    public void editTaskBuildWidth(int id, int newBuildWidth) {
        this.odoo.write("project.task", Arrays.asList(Arrays.asList(id), new HashMap<>() {{
            put("build_width", newBuildWidth);
        }}));
    }

    public void editTaskBuildLength(int id, int newBuildLength) {
        this.odoo.write("project.task", Arrays.asList(Arrays.asList(id), new HashMap<>() {{
            put("build_length", newBuildLength);
        }}));
    }

    public void editTask(int id, String newName, String newDescription, int newBuildWidth, int newBuildLength) {
        this.odoo.write("project.task", Arrays.asList(Arrays.asList(id), new HashMap<>() {{
            put("name", newName);
            put("description", newDescription);
            put("build_width", newBuildWidth);
            put("build_length", newBuildLength);
        }}));
    }

    public Object[] getAllTasks() {
        try {
            return (Object[]) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "project.task", "get_all_tasks", Arrays.asList()
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getTask(int id) {
        try {
            return this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "project.task", "get_task", Arrays.asList(id)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int createWorldAsUser(String playerUUID, int taskID, String name, String world_type) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "create_as_user", Arrays.asList(playerUUID, taskID, name, world_type)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public int createWorldAsTeam(String playerUUID, int taskID, String name, String world_type) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "create_as_team", Arrays.asList(playerUUID, taskID, name, world_type)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Status Codes:
    // 3: Other Error
    // 2: World does not exist
    // 1: User has no manager access to this world
    // 0: Success
    public int addUserToWorld(String playerUUID, String playerUUIDToAdd, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "add_user_to_world", Arrays.asList(playerUUID, playerUUIDToAdd, worldID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 3;
    }

    // Status Codes:
    // 4: Other error
    // 3: World does not exist
    // 2: User has no manager access to this world
    // 1: Team does not exist
    // 0: Success
    public int addTeamToWorld(String playerUUID, String teamName, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "add_team_to_world", Arrays.asList(playerUUID, teamName, worldID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 3: Other error
    // 2: World does not exist
    // 1: User has no manager access to this world
    // 0: Success
    public int removeUserFromWorld(String playerUUID, String playerUUIDToRemove, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "remove_user_from_world", Arrays.asList(playerUUID, playerUUIDToRemove, worldID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 4: Other error
    // 3: World does not exist
    // 2: User has no manager access to this world
    // 1: Team does not exist
    // 0: Success
    public int removeTeamFromWorld(String playerUUID, String teamName, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "remove_team_from_world", Arrays.asList(playerUUID, teamName, worldID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 4;
    }

    // Status Codes:
    // 2: Other error
    // 1: World does not exist
    // 0: Success
    public int saveWorld(int worldID, String worldData) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "save_world", Arrays.asList(worldID, worldData)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 2;
    }

    // Status Codes:
    // 2: Other error
    // 1: World does not exist
    // 0: Success
    public int editWorldType(int worldID, String worldType) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "edit_world_type", Arrays.asList(worldID, worldType)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public String getWorldData(int worldID) {
        try {
            return (String) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "get_world_data", Arrays.asList(worldID)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] getAllWorlds() {
        try {
            return (Object[]) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "get_all_worlds", Arrays.asList()
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object getWorld(int id) {
        try {
            return this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "get_world", Arrays.asList(id)
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Object[] getAllWorldTypes() {
        try {
            return (Object[]) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world.type", "get_all_world_types", Arrays.asList()
            ));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

}
