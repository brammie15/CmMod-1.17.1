//package com.brammie15.brammiecmmod.common.block.cm_centrifuge;
//
//import com.brammie15.brammiecmmod.core.init.BlockInit;
//import com.brammie15.brammiecmmod.core.init.MenuInit;
//import net.minecraft.core.BlockPos;
//import net.minecraft.world.entity.player.Inventory;
//import net.minecraft.world.entity.player.Player;
//import net.minecraft.world.inventory.*;
//import net.minecraft.world.item.ItemStack;
//import net.minecraftforge.items.IItemHandler;
//import net.minecraftforge.items.ItemStackHandler;
//
//public class CmCentrifugeMenu extends AbstractContainerMenu {
//    private static CmCentrifugeBlockEntity blockEntity;
//    private final ContainerLevelAccess containerAccess;
//    private final ContainerData data;
//    private final int amountOfSlots = 3;
//
//    public CmCentrifugeMenu(int id, Inventory playerInv) {
//
//        this(id, playerInv, new ItemStackHandler(amountOfSlots), BlockPos.ZERO, new SimpleContainerData(amountOfDataValues));
//    }
//
//    public CmCentrifugeMenu(int windowId, Inventory playerInv, IItemHandler slots, BlockPos pos,
//                            ContainerData data) {
//        super(MenuInit.CM_CENTRIFUGE_CONTAINER.get(), windowId);
//        this.containerAccess = ContainerLevelAccess.create(playerInv.player.level, pos);
//        this.data = data;
//
//        final int slotSizePlus2 = 18, startX = 8, startY = 84, hotbarY = 142;
//        for (int column = 0; column < 9; column++) {
//            for (int row = 0; row < 3; row++) {
//                addSlot(new Slot(playerInv, 9 + row * 9 + column, startX + column * slotSizePlus2, startY + row * slotSizePlus2));
//            }
//            addSlot(new Slot(playerInv, column, startX + column * slotSizePlus2, hotbarY));
//        }
//
//        // TODO: Add Slots
//        // addSlot(new SlotItemHandler(slots, index, x, y));
//
//        addDataSlots(data);
//    }
//    public static MenuConstructor getServerContainer(CmCentrifugeBlockEntity blockEntity, BlockPos pos) {
//        CmCentrifugeMenu.blockEntity = blockEntity;
//        return (id, playerInv, player) -> new CmCentrifugeMenu(id, playerInv,
//                blockEntity.getInventory(), pos, new YourMachineSyncData(blockEntity));
//    }
//
//    public CmCentrifugeBlockEntity getBlockEntity() {
//        return blockEntity;
//    }
//
//    @Override
//    public ItemStack quickMoveStack(Player player, int index) {
//        var retStack = ItemStack.EMPTY;
//        final Slot slot = this.slots.get(index);
//        if (slot != null && slot.hasItem()) {
//            final ItemStack stack = slot.getItem();
//            retStack = stack.copy();
//
//            final int size = this.slots.size() - player.getInventory().getContainerSize();
//            if (index < size) {
//                if (!moveItemStackTo(stack, 0, this.slots.size(), false))
//                    return ItemStack.EMPTY;
//            } else if (!moveItemStackTo(stack, 0, size, false))
//                return ItemStack.EMPTY;
//
//            if (stack.isEmpty() || stack.getCount() == 0) {
//                slot.set(ItemStack.EMPTY);
//            } else {
//                slot.setChanged();
//            }
//
//            if (stack.getCount() == retStack.getCount())
//                return ItemStack.EMPTY;
//
//            slot.onTake(player, stack);
//        }
//
//        return retStack;
//    }
//
//    @Override
//    public boolean stillValid(Player player) {
//        return stillValid(this.containerAccess, player, BlockInit.CM_CENTRIFUGE.get());
//    }
//}
