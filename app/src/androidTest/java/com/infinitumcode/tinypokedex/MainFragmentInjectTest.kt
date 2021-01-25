package com.infinitumcode.tinypokedex

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.infinitumcode.tinypokedex.ui.main.MainFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class MainFragmentInjectTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Test
    fun verifyInjection() {
        launchFragmentInHiltContainer<MainFragment> {
            assertThat((this as MainFragment).viewModel).isNotNull()
            this.viewModel.allPokemon.observe(this) {
                assertThat(it).isNotNull()
            }
        }
    }
}