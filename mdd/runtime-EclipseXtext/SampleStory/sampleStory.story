World
{
	fact isNightTime
	fact awaken
	fact alive
	quantity wood
	quantity food
}

abstract event Action
{
	requires awaken == true
	requires alive == true
}

event GatherWood is Action {}

event GatherFood is Action
{
	requires food < 1
	requires isNightTime == false
}

event LightFire is Action
{
	requires wood > 0
	requires isNightTime == true
} 

event BuildPyre is Action
{
	requires wood > 2
}

event Sleep is Action
{
	 requires isNightTime == true
}

event Awake 
{
	requires isNightTime == false
	requires alive == true
	requires awaken == false 
}

event Die
{
	requires alive == true
	requires food == 0
}
