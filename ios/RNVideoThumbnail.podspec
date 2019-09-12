
Pod::Spec.new do |s|
  s.name         = "RNVideoThumbnail"
  s.version      = "1.0.0"
  s.summary      = "RNVideoThumbnail"
  s.description  = "RNVideoThumbnail"
  s.homepage     = "https://github.com/mbloody/react-native-video-thumbnail.git"
  s.license      = "MIT"
  # s.license      = { :type => "MIT", :file => "FILE_LICENSE" }
  s.author             = { "author" => "author@domain.cn" }
  s.platform     = :ios, "9.0"
  s.source       = { :git => "https://github.com/author/RNVideoThumbnail.git", :tag => "master" }
  s.source_files  = "*.{h,m}"
  s.requires_arc = true

  s.dependency "React"
end
  
