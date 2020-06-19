do_install_append() {
    find ${D}/ -name '*.po' -exec rm {} \;
}
