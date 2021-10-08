package tk.gabrielpaim.espressotestexample.login

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tk.gabrielpaim.espressotestexample.R

@RunWith(AndroidJUnit4::class)
@LargeTest
class LoginTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(Login::class.java)

    @Test
    fun login_credenciaisCorretas_navegaParaHome() {
        // Digitando texto no campo de usuário
        onView(withHint("Usuario"))
            .perform(typeText("user"), closeSoftKeyboard())

        // Digitando texto no campo de senha
        onView(withId(R.id.editTextPassword))
            .perform(typeText("123"), closeSoftKeyboard())

        // Clica no botão entrar
        onView(withText("Entrar"))
            .perform(click())

        // Verifica se foi para a home
        onView(withText("Tela Principal"))
            .check(matches((isDisplayed())))
    }

    @Test
    fun login_credenciaisIncorretas_campoDeErroExibido() {
        // Digita no comapo de usuario
        onView(withHint("Usuario"))
            .perform(typeText("user"), closeSoftKeyboard())

        // Digita no campo de senha
        onView(withHint("Senha"))
            .perform(typeText("1234"), closeSoftKeyboard())

        // Clica no botão entrar
        onView(withText("Entrar"))
            .perform(click())

        onView(withText("Usuario ou senha incorretas"))
            .check(matches(isDisplayed()))
    }
}