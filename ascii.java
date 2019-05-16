Graphics2D graphics2D = (Graphics2D) graphics;
graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
  RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
graphics2D.drawString("You lose", 12, 24);

for (int y = 0; y < settings.height; y++) {
    StringBuilder stringBuilder = new StringBuilder();
 
    for (int x = 0; x < settings.width; x++) {
        stringBuilder.append(image.getRGB(x, y) == -16777216 ? "*" : " ");
    }
 
    if (stringBuilder.toString().trim().isEmpty()) {
        continue;
    }
 
    System.out.println(stringBuilder);
}
