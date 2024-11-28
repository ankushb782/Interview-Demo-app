import android.view.View
import androidx.databinding.BindingAdapter
import com.interview.erakulis.presentation.home.HomeState

@BindingAdapter("app:visibilityState")
fun visibilityState(view: View, state: HomeState?) {
    when (state) {
        is HomeState.Loading -> view.visibility = View.VISIBLE
        is HomeState.Success -> view.visibility = View.VISIBLE
        is HomeState.Error -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}
