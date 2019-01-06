package Game;

public class GameManager {

    private final IGameTeam mHomeTeam;
    private final IGameTeam mAwayTeam;

    public static boolean DEBUG_DUN = false;

    public GameManager(final IGameTeam homeTeam, final IGameTeam awayTeam){
//        Create new field object, place the teams on the field,
//        And then await the startGame call.
        mHomeTeam = homeTeam;
        mAwayTeam = awayTeam;
        generateField();
    }

    public final Object startGame(){
//        This should run cycle in a continuous loop, listening for
//        any event that would constitute the end of game play, either temporarily or permanently.
//        This will not be threaded, so you will need to handle game threading outside of here
//        Not sure what we will return yet.

        while(!DEBUG_DUN){
            cycle();
        }
        return null;
    }

    private final void cycle(){
//        This should run 1 play, also should be called by a loop within this class
//        if(mField.isMovementEnginePendingCycle()){
//            cycleMovementQueue();
//        } else {
//            calculateMovements();
//        }
    }

    private final void calculateMovements(){
        for(GamePlayer offensivePlayer : mHomeTeam.getPlayers()){
            offensivePlayer.calculateMovement();
        }

        for(GamePlayer defensivePlayer : mAwayTeam.getPlayers()){
            defensivePlayer.calculateMovement();
        }
    }

//    private final void cycleMovementQueue(){
//        mField.processFrameMovement();
//    }

    public final Object generateBoxScore(final Object style){
//        This should generate a box score of the events up to where we are
//        currently. Consider having the box score being created at the beginning
//        of the game and constantly updated as new plays are completed.
//        Style is what we will use to decide what kind of box score we want
        return null;
    }

    public final Object getRemainingTime(final Object timeReference){
//        This should return the amount of time left based on the clock type provided.
//        Examples being, Play Clock, Quarter Clock, Game Clock
//        Make sure that this return object is immutable. We dont need anyone fucking
//        around trying to change any clocks related to the game
        return null;
    }

    private final void generateField(){
//        This should generate the game field, and the place the teams on it, out of bounds.
//        Consider using this to establish team endzones as well.
//        mField = new GameFieldDep();

//        For now, add all players to the field. We will eventually have a flag that we can pass to get only the "active" players
//        for(GamePlayer player : mHomeTeam.getPlayers()){
//            mField.addPlayer(player);
//        }
//
//        for(GamePlayer player : mAwayTeam.getPlayers()){
//            mField.addPlayer(player);
//        }
    }
}
