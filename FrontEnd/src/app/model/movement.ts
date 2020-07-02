import { MovementType } from './movement-type';
import { Account } from './account';

export class Movement {
    public id:number; 
    public creationTimestamp:Date;
    public description:string;
    public amount:number;
    public movementType:MovementType = new MovementType();
    public account ={
        id:null
    };
}