package Game.GamePlay.Formation;

import Game.GamePlay.GamePlayer;
import Game.Routes.Route;
import Game.Utils.Location;
import JavaXMLUtility.MalformedXMLException;
import JavaXMLUtility.XMLHeader;
import Position.Position;
import Tuple.Tuple2;

import java.io.IOException;
import java.util.List;

public class FormationSlot {

    private final int index;
    private final Location location;
    private final Route route;
    private final List<Position> recommendedPositions;
    private GamePlayer housedPlayer;

    private final static String XML_TITLE = "slot";
    private final static String INDEX_ATTRIBUTE = "index";

    @Deprecated
    public FormationSlot(final XMLHeader input){
//    <slot index="2">
//        <location x="2" y="2"></location>
//        <route>"TESTING 3"</route>
//    </slot>
    }

    private final void verifyXMLInput(final XMLHeader input) throws MalformedXMLException {
        if(!input.getName().equalsIgnoreCase(XML_TITLE)) throw new MalformedXMLException("Invalid XML Input "+input.getName()+ "for slot");
//        TODO Create an "intelligent" way to handle situations where we are missing the index
        if(!input.containsAttribute(INDEX_ATTRIBUTE)) throw new MalformedXMLException("FormationSlot is missing the assigned index.");

        if(!input.containsAttribute(INDEX_ATTRIBUTE)) throw new MalformedXMLException("FormationSlot is missing the assigned index.");
        if(!input.containsAttribute(INDEX_ATTRIBUTE)) throw new MalformedXMLException("FormationSlot is missing the assigned index.");
    }

    public final int getIndex(){
        return index;
    }

    public final Tuple2<Double, Double> getLocation(){
        return location.getLocation();
    }

    public final Route getRoute(){
        return route;
    }

    public final List<Position> getRecommendedPositions(){
        return recommendedPositions;
    }

    public final void setPlayer(final GamePlayer player){
        housedPlayer = player;
    }

    public final GamePlayer getPlayer(){
        return housedPlayer;
    }

}
