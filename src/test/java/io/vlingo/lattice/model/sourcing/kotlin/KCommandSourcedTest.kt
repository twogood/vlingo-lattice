// Copyright © 2012-2018 Vaughn Vernon. All rights reserved.
//
// This Source Code Form is subject to the terms of the
// Mozilla Public License, v. 2.0. If a copy of the MPL
// was not distributed with this file, You can obtain
// one at https://mozilla.org/MPL/2.0/.

package io.vlingo.lattice.model.sourcing.kotlin

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue

import org.junit.Test

class KCommandSourcedTest {
    @Test
    fun testThatCtorEmits() {
        val cs = KTestCommandSourcedEntity()
        assertTrue(cs.tested1)
        assertEquals(1, cs.applied().size.toLong())
        assertEquals(KCommand1::class.java, cs.applied()[0].javaClass)
        assertFalse(cs.tested2)
        assertEquals(1, cs.applied().size.toLong())
    }

    @Test
    fun testThatEventEmits() {
        val cs = KTestCommandSourcedEntity()
        assertTrue(cs.tested1)
        assertFalse(cs.tested2)
        assertEquals(1, cs.applied().size.toLong())
        assertEquals(KCommand1::class.java, cs.applied()[0].javaClass)
        cs.doTest2()
        assertEquals(2, cs.applied().size.toLong())
        assertEquals(KCommand2::class.java, cs.applied()[1].javaClass)
    }
}
