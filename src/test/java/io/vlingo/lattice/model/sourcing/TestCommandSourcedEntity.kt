// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.sourcing


class TestCommandSourcedEntity : CommandSourced() {

    var tested1: Boolean = false
    var tested2: Boolean = false

    init {
        apply(DoCommand1())
    }

    fun doTest2() {
        apply(DoCommand2())
    }

    fun applied1(command: DoCommand1) {
        tested1 = true
    }

    fun applied2(command: DoCommand2) {
        tested2 = true
    }

    companion object {
        init {
            registerConsumer(TestCommandSourcedEntity::applied1)
            registerConsumer(TestCommandSourcedEntity::applied2)
        }
    }
}
