import { HolderType } from './holder-type';
import { LegalEntity } from './legal-entity';

export class NaturalPerson {
    public id:number; 
    public name:string;
    public lastName:string;
    public nit:string;
    public creationTimestamp:Date = new Date();
}