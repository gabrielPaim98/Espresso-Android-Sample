package tk.gabrielpaim.espressotestexample.home

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tk.gabrielpaim.espressotestexample.R
import tk.gabrielpaim.espressotestexample.login.Login

@RunWith(AndroidJUnit4::class)
@LargeTest
class HomeTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Login::class.java)

    @Test
    fun voltar_usuarioLogado_voltaParaLogin() {
        // Garante que está na home
        onView(withHint("Usuario"))
            .perform(typeText("user"), ViewActions.closeSoftKeyboard())
        onView(withId(R.id.editTextPassword))
            .perform(typeText("123"), ViewActions.closeSoftKeyboard())
        onView(withText("Entrar"))
            .perform(click())
        onView(withText("Tela Principal"))
            .check(matches((isDisplayed())))

        // Clica no botão
        onView(withText("Sair"))
            .perform(click())

        onView(withText("Entrar"))
            .check(matches((isDisplayed())))
    }
}