package usarb.lab5.third;

import usarb.lab5.second.Container;

public interface IFactory {
    Container createContainer(Strategy strategy);
}