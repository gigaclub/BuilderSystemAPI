package net.gigaclub.buildersystem;

import net.gigaclub.teamapi.Team;
import org.apache.xmlrpc.XmlRpcException;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BuilderSystem extends Team {

    public BuilderSystem(String hostname, String database, String username, String password) {
        super(hostname, database, username, password);
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

    public JSONArray getAllTasks() {
        try {
            return new JSONArray(this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "project.task", "get_all_tasks", Arrays.asList()
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getTask(int id) {
        try {
            return new JSONObject((Map<String, String>) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "project.task", "get_task", Arrays.asList(id)
            )));
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

    public int createWorldAsTeam(String playerUUID, int teamId, int taskID, String name, String world_type) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "create_as_team", Arrays.asList(playerUUID, teamId, taskID, name, world_type)
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
    public int addTeamToWorld(String playerUUID, int teamId, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "add_team_to_world", Arrays.asList(playerUUID, teamId, worldID)
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
    public int removeTeamFromWorld(String playerUUID, int teamId, int worldID) {
        try {
            return (int) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "remove_team_from_world", Arrays.asList(playerUUID, teamId, worldID)
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

    public JSONArray getAllWorlds() {
        try {
            return new JSONArray(this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "get_all_worlds", Arrays.asList()
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONObject getWorld(int id) {
        try {
            return new JSONObject((Map<String, String>) this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world", "get_world", Arrays.asList(id)
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getAllWorldTypes() {
        try {
            return new JSONArray(this.odoo.getModels().execute("execute_kw", Arrays.asList(
                    this.odoo.getDatabase(), this.odoo.getUid(), this.odoo.getPassword(),
                    "gc.builder.world.type", "get_all_world_types", Arrays.asList()
            )));
        } catch (XmlRpcException e) {
            e.printStackTrace();
        }
        return null;
    }

}
