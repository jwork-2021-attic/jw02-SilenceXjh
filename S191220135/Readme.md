## W02

example类图

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-SilenceXjh/master/S191220135/uml/egCharacters.pu)

example时序图

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-SilenceXjh/master/S191220135/uml/egTimeline.pu)

实例代码要实现的功能是 “老爷爷指挥七个葫芦娃按排行顺序站成一队” 。由此，直接能得到的两个类便是老爷爷和葫芦娃。而为了进一步提高抽象化的程度，把葫芦娃抽象为“可排队的实体”，所以引入接口Linable，而葫芦娃作为一种Linable的实体，对该接口进行实现。考虑到葫芦娃有且仅有七个，所以将其设置为枚举类型。

对于排队的过程，定义类型Line来作为队列，而队列中的元素并没有直接用Linable，而是又新定义了一个类Position。这样，Position还可作为Linable实体的一个属性，即每个可排序的实体有自己的位置，队列的每个位置上站着一个可排序的实体。相比直接把Linable作为队列的元素，这样设计可以使Linable实体的属性特征得到更充分的刻画。

对于排序，定义一个接口Sorter，由具体的排序算法如BubbleSorter对其进行实现。Sorter是老爷爷的一个属性，setSorter方法就形象反映了“老爷爷习得某种排序算法”的过程。

老爷爷的LineUp方法里，先利用sort得到排序的策略（此处只是对数组的排序），然后根据这个策略将葫芦娃进行排序，这里将Position作为Gourd的属性以及将Linable作为Position的属性的好处就体现出来了，可以通过swapPosition和setLinable方法使葫芦娃的位置得到实质的改变。

此外，老爷爷这个类里定义了一个静态变量theGreezer，在Scene中生成老爷爷对象时也是用的这个静态变量。这里的用意应该是保证老爷爷只有一个。

Position类被定义为了Line类的内部类，这样做的好处是Line类的方法可以直接访问Position类的私有成员。对于Line和Position这两个关系很密切的类来说，这样就很方便。

可改进之处：

一个小小的瑕疵：Line类的get方法里i > positions.length应改为i >= positions.length。

在swap方法里，plan记录的交换是a[i]和a[j]，当然这里是因为葫芦娃是枚举类型，可以直接根据枚举值获得对象。但我感觉元素交换时记录下标似乎比记录值更合理一些（仅个人感觉）。

在整体设计上，我觉得老师的设计足够精巧且合理，确实没有改进意见。



任务二类图

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-SilenceXjh/master/S191220135/uml/task2_characters.pu)

任务三类图

![](http://www.plantuml.com/plantuml/proxy?cache=no&src=https://raw.githubusercontent.com/jwork-2021/jw02-SilenceXjh/master/S191220135/uml/task3_characters.pu)

视频已上传至b站

https://www.bilibili.com/video/BV1tg411F7Ri?share_source=copy_web