package pckg.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pckg.entity.Item;
import pckg.repository.ItemRepository;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {

	private final ItemRepository itemRepository;
	
	public ItemController(ItemRepository itemRepository) {
		this.itemRepository = itemRepository;
	}
	
	@GetMapping
	public List<Item> selectAllItems() {
		return itemRepository.selectAllItems();
	}
	
}
