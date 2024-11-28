import androidx.recyclerview.widget.DiffUtil
import com.interview.erakulis.domain.Image

class ImageDiffCallback : DiffUtil.ItemCallback<Image>() {

    // Check if two objects represent the same item
    override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem.id == newItem.id  // Assuming 'id' is the unique identifier of Image
    }

    // Check if the contents of the items are the same
    override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
        return oldItem == newItem  // Compare the contents (could be all fields)
    }
}
