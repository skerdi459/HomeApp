import { Location } from './location';
import { Type } from './type';
import { Attribute } from './attribute';


export class Equipment {
    id:string;
    name:string;
    state:number;
    type:Type;
    location:Location;
    attributes:Attribute[];
 

}
