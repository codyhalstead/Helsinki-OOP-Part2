/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxes;

/**
 *
 * @author Cody
 */
public class OneThingBox extends Box{
    private Thing thingInBox = null;

    @Override
    public void add(Thing thing) {
        if (thingInBox == null){
            thingInBox = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing) {
        if (thingInBox == null){
            return false;
        }
        return (thingInBox.equals(thing));
    }
}