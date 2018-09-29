package io.vlingo.lattice.model.sourcing

import io.vlingo.lattice.model.Source
import kotlin.reflect.KFunction2


inline fun <S, reified T : Sourced<S>, reified U : Source<S>> registerConsumer(kFunction2: KFunction2<T, U, Unit>) {
    Sourced.registerConsumer(T::class.java, U::class.java) { key, value -> kFunction2.call(key, value) }
}

