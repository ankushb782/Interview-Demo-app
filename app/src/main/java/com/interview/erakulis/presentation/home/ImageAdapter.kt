import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.interview.erakulis.databinding.ItemImageBinding // Make sure to use your generated binding class
import com.interview.erakulis.domain.Image

class ImageAdapter(param: (Image) -> Unit) : ListAdapter<Image, ImageAdapter.ImageViewHolder>(ImageDiffCallback()) {

    // Define the ViewHolder class
    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(image: Image) {
            binding.image = image // Bind the image object to the layout
            binding.executePendingBindings()
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val image = getItem(position)
        holder.bind(image)
    }
}
