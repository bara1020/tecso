import { Movement } from './movement';
import { CurrencyAccount } from './currency-account';

export class Account {
    public id:number; 
    public numberAccount:number;
    public balance:number;
    public creationTimestamp:Date;
    public currency:CurrencyAccount = new CurrencyAccount();
    public movementList:Array<Movement>;
}