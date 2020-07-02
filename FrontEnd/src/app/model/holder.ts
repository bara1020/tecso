import { HolderType } from './holder-type';
import { LegalEntity } from './legal-entity';
import { NaturalPerson } from './natural-person';

export class Holder {
    public id:number; 
    public rut:string;
    public creationTimestamp:Date = new Date();
    public holderType:HolderType = new HolderType();
    public legalEntity?:LegalEntity;
    public naturalPerson:NaturalPerson;
}