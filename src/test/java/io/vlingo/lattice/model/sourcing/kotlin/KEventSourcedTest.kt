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

class KEventSourcedTest {
    @Test
    fun testThatCtorEmits() {
        val es = KTestEventSourcedEntity()
        assertTrue(es.tested1)
        assertEquals(1, es.applied().size.toLong())
        assertEquals(KTest1Happened::class.java, es.applied()[0].javaClass)
        assertFalse(es.tested2)
        assertEquals(1, es.applied().size.toLong())
    }

    @Test
    fun testThatCommandEmits() {
        val es = KTestEventSourcedEntity()
        assertTrue(es.tested1)
        assertFalse(es.tested2)
        assertEquals(1, es.applied().size.toLong())
        assertEquals(KTest1Happened::class.java, es.applied()[0].javaClass)
        es.doTest2()
        assertEquals(2, es.applied().size.toLong())
        assertEquals(KTest2Happened::class.java, es.applied()[1].javaClass)
    }
}
