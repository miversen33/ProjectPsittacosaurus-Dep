//package Game;
//
//import FieldDep.FieldCell;
//import FieldDep.FieldCellState;
//import PhysicsEngine.MovementEngine;
//import PhysicsEngine.MovementInstruction;
//
//import java.util.*;
//
//public class GameFieldDep {
//
//    private final static int FIELD_WIDTH = 160;
//    private final static int FIELD_HEIGHT = 360;
//    private final static int FIELD_NORTH_ENDZONE_HEIGHT = 30;
//    private final static int FIELD_SOUTH_ENDZONE_HEIGHT = 330;
//
//    private final FieldCell[][] mFieldArray = new FieldCell[FIELD_WIDTH][FIELD_HEIGHT];
//
////    We need a "starting" location for new players entering the field, until they are moved
////    That or we need to have the starting position passed to the field. I dont
////    know how I feel about that though
//    private final FieldCell defaultCell;
//
//    private final String mHash = UUID.randomUUID().toString();
//
////    Consider only allowing 2 teams here?
//    private final Map<String, List<GamePlayer>> mValidPlayersMap = new HashMap<>();
//
//    private final Map<GamePlayer, FieldCell> mLocations = new HashMap<>();
//
//    private MovementEngine movementEngine;
//
//    public GameFieldDep(){
//        initFieldCells();
//        defaultCell = mFieldArray[0][0];
//        movementEngine = new MovementEngine(this);
//    }
//
//    private final void initFieldCells(){
//        FieldCellState state = FieldCellState.NORTH_ENDZONE;
//
//        for(int y = 0; y < FIELD_HEIGHT; y++){
//            if(y == FIELD_NORTH_ENDZONE_HEIGHT + 1) state = FieldCellState.GAME_FIELD;
//            if(y == FIELD_SOUTH_ENDZONE_HEIGHT) state = FieldCellState.SOUTH_ENDZONE;
//            for(int x = 0; x < FIELD_WIDTH; x++){
//                mFieldArray[x][y] = new FieldCell(x, y, state);
//            }
//        }
//    }
//
//    public final boolean compareHash(final String hash){
//        return mHash.equals(hash);
//    }
//
//    public final boolean compareHash(final GameFieldDep field){
//        return compareHash(field.mHash);
//    }
//
//    public final void addPlayer(final GamePlayer player){
//        if(mValidPlayersMap.containsKey(player.getTeamHash())){
//            mValidPlayersMap.get(player.getTeamHash()).add(player);
////          Default starting location for any player
//            mLocations.put(player, defaultCell);
//            player.placeOnField(this);
//        } else {
//            final ArrayList<GamePlayer> teamList = new ArrayList<>();
//            mValidPlayersMap.put(player.getTeamHash(), teamList);
//            addPlayer(player);
//        }
//    }
//
//
//    public final void removePlayer(final GamePlayer player) {
//        if(!mValidPlayersMap.containsKey(player.getTeamHash())){
////            Log team not player team is not on field.
////            Refuse to remove player from field
//            return;
//        }
//        mValidPlayersMap.get(player.getTeamHash()).remove(player);
//        mLocations.remove(player);
//        player.removeFromField(this);
//    }
//
//    public final List<GamePlayer> getPlayers(){
//        return getPlayers(null);
//    }
//
//    public final List<GamePlayer> getPlayers(final String gameTeamHash){
//        ArrayList<GamePlayer> players = new ArrayList<>();
//        if(gameTeamHash == null || gameTeamHash.isEmpty()){
//            for(List<GamePlayer> playerList : mValidPlayersMap.values()){
//                players.addAll(playerList);
//            }
//        } else {
//            players.addAll(mValidPlayersMap.get(gameTeamHash));
//        }
//        return players;
//    }
//
//    public final void movePlayer(final GamePlayer player, final FieldCell newLocation){
////        Consider a way to add authentication here
//        if(!mLocations.containsKey(player)){
////            Handle logging due to requested player movement not being valid, as player
////            is not on the field yet
//            return;
//        }
//        final FieldCell currentLocation = mLocations.get(player);
//        currentLocation.occupy(null);
//        newLocation.occupy(player);
//        mLocations.put(player, newLocation);
//        player.movePlayer(newLocation, mHash);
//    }
//
//    public final FieldCell requestLocation(final GamePlayer player){
//        if(mLocations.containsKey(player)){
////            Handle logging due to player not being on field
////            Refuse to provide location
//            return null;
//        }
//        return mLocations.get(player);
//    }
//
//    public final void requestMovement(final MovementInstruction instruction){
//        movementEngine.requestMovement(instruction);
//    }
//
//    public final FieldCell getCell(final int x, final int y){
//        if(!((x >= 0 && x < FIELD_WIDTH) && (y >= 0 && y < FIELD_HEIGHT))) {
////            Handle logging due to requested location not being on field.
////            I am not sure if I should throw an exception or just return null
//            System.out.println("Unable to provide location for ("+x+","+y+")");
//            return null;
//        } else {
//            return mFieldArray[x][y];
//        }
//    }
//
//    public final boolean isMovementEnginePendingCycle(){
//        return movementEngine.isPendingCycle();
//    }
//
//    public final void processFrameMovement(){
//        movementEngine.cycleQueue();
//    }
//}
