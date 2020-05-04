import {World} from "./World";

export interface IWorldGetter {
	getWorld(): Promise<World>
}