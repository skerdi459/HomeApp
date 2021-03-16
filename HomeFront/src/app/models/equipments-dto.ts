import { Attribute } from './attribute';


export class EquipmentsDto {

    id:string;
    name:string;
    state:number;
    type:string;
    location:string;
    attributes:Attribute[];
}
