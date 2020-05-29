DEPENDS += " ${@bb.utils.contains("MACHINE_FEATURES", "sdl", "libsdl", "", d)} "

FILES_${PN} += "\
  ${libdir}/directfb-${RV}/gfxdrivers/*.so \
"

FILES_${PN}-dev += "\
  ${libdir}/directfb-${RV}/gfxdrivers/*.la \
"
