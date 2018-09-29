// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.sourcing.kotlin

import io.vlingo.lattice.model.sourcing.EventSourced

class KTestEventSourcedEntity : EventSourced() {

    var tested1: Boolean = false
    var tested2: Boolean = false

    init {
        apply(KTest1Happened())
    }

    fun doTest2() {
        apply(KTest2Happened())
    }

    fun applied1(event: KTest1Happened) {
        tested1 = true
    }

    fun applied2(event: KTest2Happened) {
        tested2 = true
    }

    companion object {
        init {
            registerConsumer(KTestEventSourcedEntity::applied1)
            registerConsumer(KTestEventSourcedEntity::applied2)
        }
    }
}
